package com.ixan.example.application.service.query;
/**
 * 只放查询相关，可以直接调用持久层
 * 注1：出参必须为 DTO
 * 注2：入参为 Command 或 Query,唯一例外是单ID查询的场景
 * 注3：Command 和 Query 有语义作用，避免复用
 * 注4：通过 Spring Validation 来实现入参校验，减少非业务代码混杂业务代码中
 */