package com.ximo.order.util;

import com.ximo.order.enums.ResultEnums;
import com.ximo.order.exception.OrderException;
import org.slf4j.Logger;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.function.Consumer;

import static com.ximo.order.constants.CommonConstants.COMMA;
import static java.util.stream.Collectors.joining;

/**
 * @author Ximo
 * @date 2018/10/7 15:47
 */
public class ConstraintUtil {

    private ConstraintUtil() {
        throw new UnsupportedOperationException();
    }

    public static void orElseThrow(BindingResult errors, Logger log, Consumer<Logger> errorLog) {
        if (errors.hasErrors()){
            errorLog.accept(log);
            throw new OrderException(ResultEnums.PARAM_ERROR.getCode(), errors.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(joining(COMMA)));
        }
    }

}
