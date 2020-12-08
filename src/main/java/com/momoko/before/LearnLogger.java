package com.momoko.before;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * Created by momoko on 2020/6/19.
 */
public class LearnLogger {
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            logger.severe("Invalid Charset Name");
        }
        logger.info("Process end.");
    }
}