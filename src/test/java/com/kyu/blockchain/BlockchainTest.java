package com.kyu.blockchain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @Project : blockchain
 * @Date : 2017-12-14
 * @Author : nklee
 * @Description :
 */
public class BlockchainTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test() throws JsonProcessingException {
        Blockchain blockchain = new Blockchain();
        blockchain.addBlock(new Block(1, "2017-01-01", "{amount : 4}"));
        blockchain.addBlock(new Block(2, "2017-01-02", "{amount : 10}"));
        assertThat(true, is(blockchain.isChainValid()));

        // print json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(mapper.writeValueAsString(blockchain.getChain()));;

        // Changing a block
        Block block = blockchain.getBlock(1);
        block.setData("{ amount : 100 }");
        assertThat(false, is(blockchain.isChainValid()));
    }

}