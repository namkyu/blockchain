package com.kyu.blockchain;

import com.google.common.hash.Hashing;
import lombok.Data;

import java.nio.charset.StandardCharsets;

/**
 * @Project : blockchain
 * @Date : 2017-12-14
 * @Author : nklee
 * @Description :
 */
@Data
public class Block {

    private int index;
    private String timestamp;
    private String data;
    private String hash;
    private String previousHash;

    public Block(int index, String timestamp, String data) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = this.calculateHash();
    }

    public Block(int index, String timestamp, String data, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = this.calculateHash();
    }

    public String calculateHash() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.index);
        builder.append(this.previousHash);
        builder.append(this.timestamp);
        builder.append(this.data);

        return Hashing.sha256()
                .hashString(builder.toString(), StandardCharsets.UTF_8)
                .toString();
    }
}
