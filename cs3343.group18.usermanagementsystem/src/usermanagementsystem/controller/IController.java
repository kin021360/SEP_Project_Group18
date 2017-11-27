package usermanagementsystem.controller;

import usermanagementsystem.exception.ExInvalidChoice;

/**
 * Created by Nathan Lam on 24/11/2017.
 */

/**
 * Provide general method access for controller class
 */
public interface IController {
    /**
     * Validate the choice and get choice detail
     *
     * @param choice string number, 0 based
     * @return string description for the choice, can be empty string
     * @throws ExInvalidChoice no existing choice in controller
     */
    String validateChoiceGetFuncDetail(String choice) throws ExInvalidChoice;

    /**
     * Involve the action based on the choice
     *
     * @param choice string number, 0 based
     * @param values for the choice, in string array / string array param
     * @return string message
     * @throws Exception include the message that the action cannot be executed
     */
    String choiceHandler(String choice, String... values) throws Exception;

    /**
     * @return all supported choices function description
     */
    String getAllFunctionsDesc();

    /**
     * Clear current user session in controller
     */
    void clear();
}
