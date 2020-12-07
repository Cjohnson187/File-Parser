package com.chris.parserV2;

import java.util.ArrayList;

public class BufferParser {
    final String fileIn = "src/com/chris/input/master";
    final String fileOut = "src/com/chris/outFiles/outFileBuffered";
    public static void main(String[] args) {
        ArrayList<DataBean> beanList = new ArrayList<DataBean>();
        BufferParser parser = new BufferParser();


        // make inputBuffer with file
        // process input file toa  bean
        // save processed info to beansList
        // make output file
        // print beanList to file


    }

    public void processIn() {
        // 1- make input buffer
        // 2- while has next
            // a- get line
            // b- parse line
            // c- add bean to bean list
        // 3- close input buffer
        // 4- return beanList
    }
    public void processOut() {
        // 5- make outputStream
        // 6- for each bean in list
            // a- write to file
        //close
    }
}
