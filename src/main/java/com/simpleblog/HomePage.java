package com.simpleblog;

import com.simpleblog.factory.BlogPostFactory;
import com.simpleblog.model.BlogPost;
import java.util.ArrayList;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
                
                
                BlogPostFactory factory = new BlogPostFactory();
                ArrayList<BlogPost> posts = factory.createListOfBlogs(2);
                
                
                add(new Label("numberOfPosts", posts.size()));
                
                

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here

    }
}
