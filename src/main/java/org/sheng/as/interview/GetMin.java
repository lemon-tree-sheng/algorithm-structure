package org.sheng.as.interview;

import java.util.Stack;

/**
 * @author shengxingyue on 2018/4/23 20:22
 */
public class GetMin {
    public static void main(String[] args) {
        GetMinStack getMinStack = new GetMinStack();
        getMinStack.push(2);
        getMinStack.push(4);
        getMinStack.push(1);
        getMinStack.push(9);
        getMinStack.push(7);
        getMinStack.push(8);

        while (getMinStack.size() > 0) {
            int tmp = getMinStack.pop();
            System.out.println("pop:" + tmp);
            if (getMinStack.size() > 0) {
                System.out.println("min value:" + getMinStack.getMin());
            }
        }
    }
}

class GetMinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    GetMinStack() {
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(Integer data) {
        dataStack.push(data);
        if (minStack.size() == 0 || minStack.peek() >= data) {
            minStack.push(data);
        }
    }

    public Integer pop() {
        if (dataStack.size() == 0) {
            return null;
        }
        Integer result = dataStack.pop();
        if (result.equals(minStack.peek())) {
            minStack.pop();
        }
        return result;
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public int size() {
        return dataStack.size();
    }
}
