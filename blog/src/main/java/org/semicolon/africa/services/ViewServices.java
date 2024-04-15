package org.semicolon.africa.services;


import org.semicolon.africa.dtos.ViewRequest;
import org.semicolon.africa.dtos.ViewResponse;

public interface ViewServices {
    ViewResponse viewPosts(ViewRequest viewRequest);
}
