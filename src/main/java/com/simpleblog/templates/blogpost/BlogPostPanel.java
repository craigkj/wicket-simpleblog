/*
 * Copyright 2013 craigjones.
 *
 */
package com.simpleblog.templates.blogpost;

import com.simpleblog.model.BlogPost;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author craigjones
 */
public class BlogPostPanel extends Panel {

    /**
     * Adds a basic blog view panel
     * @param id
     * @param model 
     */
    public BlogPostPanel(String id, IModel<BlogPost> model) {
        super(id, model);
        this.populateData(model);
    }
    
    /**
     * Populate Data
     * @param model 
     */
    private void populateData(IModel<BlogPost> model){
        
        BlogPost post = model.getObject();
        
        // Post Title
        add(new Label("post-title", post.getTitle()));
        // Post Text
        //add(new Label("post-text", post.getText()));
        // Author Name
        add(new Label("post-author", post.getAuthor().getName()));
        
    }
    
}
