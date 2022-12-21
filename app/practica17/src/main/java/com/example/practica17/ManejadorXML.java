package com.example.practica17;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorXML extends DefaultHandler {
    private final StringBuilder resultado=new StringBuilder();
    private final StringBuilder modoTexto=new StringBuilder();
    private boolean entryTag;
    private String total;

    public String getResultado(){
        return resultado.toString();
    }
    @Override
    public void startElement(String url, String localName, String qName, Attributes attributes)throws SAXException{
        modoTexto.setLength(0);
        if (localName.equals("entry"))
            entryTag=true;
    }
    @Override
    public void characters(char[] ch,int start,int length) throws SAXException{
        modoTexto.append(ch,start,length);
    }
    @Override

}
