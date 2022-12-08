/*
 * Author Name: Pratik Goud
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.BEJC2_S3_REST_API_MONGODB_PC_1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Customer with specified details Already Exists")
public class customerAlreadyExists extends Exception{
}
