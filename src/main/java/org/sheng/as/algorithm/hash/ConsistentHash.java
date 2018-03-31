package org.sheng.as.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author shengxingyue, created on 2018/3/31
 *         一致性 hash 算法实现
 *         <p>
 *         1. hash 算法：将服务器节点和缓存节点在 hash 环上找到位置
 *         2. 记录服务器在 hash 环上的位置
 *         3. 计算缓存节点的 hash 值，判断应该存储的服务器位置
 *         判断逻辑：缓存节点的 hash 值处于某两个服务器 hash 值之间则存储到较大 hash 值的服务器上；若只有比自己小的服务器节点那么直接 hash 到 hash 值最小的服务器节点上
 *         4. todo 虚拟节点的一致性 hash 实现
 */
@Slf4j
public class ConsistentHash {

    /**
     * 存储服务器列表
     * key:server's hashCode
     * value:serverName
     */
    private static TreeMap<Integer, String> serverMap = new TreeMap<Integer, String>();

    /**
     * 确定服务器的 hash 值并存储
     */
    static {
        String[] servers = {"192.168.10.1", "192.168.11.4", "192.168.6.8", "192.168.23.1"};
        for (String server : servers) {
            int hash = hash(server);
            serverMap.put(hash, server);
            log.info("服务器 {} 的 hash 位置为 {}", server, hash);
        }
    }

    /**
     * 缓存设置
     *
     * @param cacheNode
     */
    public static void put(String cacheNode) {
        int hash = hash(cacheNode);
        // 找到应该路由到的服务器节点
        String target;
        SortedMap<Integer, String> subMap = serverMap.tailMap(hash);
        if (subMap.isEmpty()) {
            // 找不到 hash 值更大的服务器节点，路由到第一个服务器
            target = serverMap.firstEntry().getValue();
        } else {
            // 找到则返回第一个 hash 值比缓存节点大的服务器节点
            target = serverMap.get(subMap.firstKey());
        }
        log.info("缓存 {} hash 值为 {} 放到服务器 {} 上", cacheNode, hash, target);
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值
     *
     * @return
     */
    private static int hash(String str) {
        int result;
        final int p = 16777619;
        result = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            result = (result ^ str.charAt(i)) * p;
        }
        result += result << 13;
        result ^= result >> 7;
        result += result << 3;
        result ^= result >> 17;
        result += result << 5;

        // 如果算出来的值为负数则取其绝对值
        if (result < 0) {
            result = Math.abs(result);
        }
        return result;
    }

    public static void main(String[] args) {
        // 放置缓存
        put("abc");
        put("123");
        put("nkb");
        put("nlz");
    }
}
