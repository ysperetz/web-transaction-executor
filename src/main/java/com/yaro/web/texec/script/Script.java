package com.yaro.web.texec.script;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author v-yshneykin
 * @since 4/3/18
 */
public class Script {

    private final String baseUrl;
    private final long execTimeLimit;
    private final ImmutableList<Transaction> transactions;

    public Script(String baseUrl, long execTimeLimit, List<Transaction> transactions) {
        this.baseUrl = baseUrl;
        this.execTimeLimit = execTimeLimit;
        this.transactions = ImmutableList.copyOf(transactions);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public long getExecTimeLimit() {
        return execTimeLimit;
    }

    public ImmutableList<Transaction> getTransactions() {
        return transactions;
    }
}
