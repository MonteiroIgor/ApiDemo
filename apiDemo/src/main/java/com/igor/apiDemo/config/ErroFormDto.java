package com.igor.apiDemo.config;

public class ErroFormDto {

    private String campo;
    private String msgErro;

    public ErroFormDto(String campo, String msgErro) {
        this.campo = campo;
        this.msgErro = msgErro;
    }

    public String getCampo() {
        return campo;
    }

    public String getMsgErro() {
        return msgErro;
    }
}
