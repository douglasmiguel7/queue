package com.github.douglasmiguel7.queue.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/v1", headers = "Authorization", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public abstract class AbstractBaseV1API {
}
