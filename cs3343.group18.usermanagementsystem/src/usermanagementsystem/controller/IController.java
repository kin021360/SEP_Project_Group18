package usermanagementsystem.controller;

import usermanagementsystem.exception.ExInvalidChoice;

/**
 * Created by Nathan Lam on 24/11/2017.
 */
public interface IController {
    String validateChoiceGetFuncDetail(String choice) throws ExInvalidChoice;

    String choiceHandler(String choice, String... values) throws Exception;

    String getAllFunctionsDesc();

    void clear();
}
