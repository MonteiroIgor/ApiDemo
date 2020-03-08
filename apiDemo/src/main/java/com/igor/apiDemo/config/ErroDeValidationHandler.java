package com.igor.apiDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidationHandler {

    @Autowired
    private MessageSource messageSource;

    /* METODO É CHAMADO QUANDO HOUVER EXCESSÃO NO CONTROLE, PASSANDO COMO PARAMETRO QUAL TIPO DE EXCESSÃO,
    NESSE CASO EXCESSÃO DE FORMULÁRIO */

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormDto> handle(MethodArgumentNotValidException exception){

        List<ErroFormDto> erroFormDto = new ArrayList<>();

        // TODO: fieldErros: contém erros de formulários
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        // TODO: PARA CADA ERRO DEVE EXTRAIR:
        fieldErrors.forEach(e ->{
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroFormDto erro = new ErroFormDto(e.getField(), mensagem);

            erroFormDto.add(erro);
        });
    return erroFormDto;
    }
}
