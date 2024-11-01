package com.teachmeskills.lesson_8.document_parser.impl;

import com.teachmeskills.lesson_8.document_parser.IParser;

public class TxtDocumentParser implements IParser {

    @Override
    public void parseFile(String fileName) {
        System.out.println("Получить данные из тхт документ");
    }

}
