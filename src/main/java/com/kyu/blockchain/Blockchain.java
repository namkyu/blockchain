package com.kyu.blockchain;

import lombok.Getter;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project : blockchain
 * @Date : 2017-12-14
 * @Author : nklee
 * @Description :
 */
public class Blockchain {

    @Getter
    private List<Block> chain = new ArrayList<>();

    public Blockchain() {
        chain.add(this.createGenesisBlock());
    }

    public Block createGenesisBlock() {
        return new Block(0, "2017-01-01", "Genesis block", "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public Block getBlock(int index) {
        return chain.get(index);
    }

    public void addBlock(Block newBlock) {
        newBlock.setPreviousHash(this.getLatestBlock().getHash());
        newBlock.setHash(newBlock.calculateHash());
        this.chain.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = this.chain.get(i);
            Block previouseBlock = this.chain.get(i - 1);

            if (currentBlock.getHash().equals(currentBlock.calculateHash()) == false) {
                return false;
            }

            if (currentBlock.getPreviousHash().equals(previouseBlock.getHash()) == false) {
                return false;
            }
        }

        return true;
    }
}
