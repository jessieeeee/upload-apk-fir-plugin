package com.demo.plugin

import com.google.gson.Gson

public class DingTalk {
    Gson gson
    public DingTalk(){
        gson = new Gson()
    }

    def class LinkMsg{
        String msgtype
        Link link

        public LinkMsg(String msgtype,Link link){
            this.msgtype = msgtype
            this.link = link
        }
    }

    def class Link{
        String title
        String text
        String messageUrl

        public Link(String title,String text,String messageUrl){
            this.title = title
            this.text = text
            this.messageUrl = messageUrl
        }
    }

    def class TextMsg{
        String msgtype
        Text text

        public TextMsg(String msgtype,Text text){
            this.msgtype = msgtype
            this.text = text
        }
    }

    def class Text{
        String content

        public Text(String content){
            this.content = content
        }
    }

    /**
     * 构建一个钉钉链接消息
     * @param text String
     * @param title String
     * @param url String
     * @return String
     */
    String createLinkMsg(String text ,String title,String url) {
        Link link = new Link(title,text,url)
        LinkMsg linkMsg = new LinkMsg("link",link)
        return gson.toJson(linkMsg)
    }

    /**
     * 构建一个钉钉文本消息
     * @param msgtype String
     * @param content String
     * @param text String
     * @return String
     */
    String createTextMsg(String content){
        Text text = new Text(content)
        TextMsg textMsg = new TextMsg("text", text)
        return gson.toJson(textMsg)
    }
}