package com.simpleblog;

import org.apache.wicket.markup.html.WebPage;

public class GuestBookApplication extends WicketApplication {
    public GuestBookApplication() {
    }

    @Override
    public Class< ? extends WebPage> getHomePage() {
        return GuestBook.class;
    }
}
