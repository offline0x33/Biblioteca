/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.auth.compression;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.ws.rs.NameBinding;

/**
 * Indicates that the annotated element or method should be compressed using GZIP.
 *
 * This annotation can be applied to classes, methods, or fields to signal that the
 * data associated with them should be compressed using the GZIP algorithm.
 *
 * @author Santiago Pericas-Geertsen
 */
@NameBinding
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Gzipped {
}
