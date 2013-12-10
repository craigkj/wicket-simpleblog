package com.simpleblog;

import com.simpleblog.factory.BlogPostFactory;
import com.simpleblog.model.BlogPost;
import com.simpleblog.templates.blogpost.BlogPostPanel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);

        DoNonsesnse();

        BlogPostFactory factory = new BlogPostFactory();
        ArrayList<BlogPost> posts = factory.createListOfBlogs(2);

        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        // TODO Add your page's components here
    }

    private void DoNonsesnse() {

        BlogPostFactory factory = new BlogPostFactory();
        ArrayList<BlogPost> posts = factory.createListOfBlogs(2);

        add(new Label("numberOfPosts", posts.size()));

        List list = Arrays.asList(new String[]{"a", "b", "c"});

        ListView<BlogPost> listview = new ListView<BlogPost>("listview", posts) {
            protected void populateItem(ListItem<BlogPost> item) {

//                BlogPost post = (BlogPost) item;

                item.add(new BlogPostPanel("panel", item.getModel()));
                //item.add(new Label("label", item.getModel()));
            }
        };
        add(listview);

    }
}
