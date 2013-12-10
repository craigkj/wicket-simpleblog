package com.simpleblog;

import com.simpleblog.model.Comment;
import com.simpleblog.factory.BlogPostFactory;
import com.simpleblog.model.BlogPost;
import com.simpleblog.templates.blogpost.BlogPostPanel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.value.ValueMap;

public final class GuestBook extends WebPage {

    /**
     * A global list of all comments from all users across all sessions
     */
    private static final List<Comment> commentList = Collections.synchronizedList(new ArrayList<Comment>());

    /**
     * Constructor that is invoked when page is invoked without a session.
     */
    public GuestBook() {
        // Add comment form
        add(new CommentForm("commentForm"));
        this.DoNonsesnse();



        // Add commentListView of existing comments
        add(new PropertyListView<Comment>("comments", commentList) {
            @Override
            public void populateItem(final ListItem<Comment> listItem) {
                listItem.add(new Label("date"));
                listItem.add(new MultiLineLabel("text"));
            }
        }).setVersioned(false);
    }

    /**
     * A form that allows a user to add a comment.
     */
    public final class CommentForm extends Form<ValueMap> {

        public CommentForm(final String id) {
            // Construct form with no validation listener
            super(id, new CompoundPropertyModel<ValueMap>(new ValueMap()));

            // this is just to make the unit test happy
            setMarkupId("commentForm");

            // Add text entry widget
            add(new TextArea<String>("text").setType(String.class));

            // Add simple automated spam prevention measure.
            add(new TextField<String>("comment").setType(String.class));
        }

        /**
         * Show the resulting valid edit
         */
        @Override
        public final void onSubmit() {
            ValueMap values = getModelObject();

            // check if the honey pot is filled
            if (StringUtils.isNotBlank((String) values.get("comment"))) {
                error("Caught a spammer!!!");
                return;
            }
            // Construct a copy of the edited comment
            Comment comment = new Comment();

            // Set date of comment to add
            comment.setDate(new Date());
            comment.setText((String) values.get("text"));
            commentList.add(0, comment);

            // Clear out the text component
            values.put("text", "");
        }
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

    /**
     * Clears the comments.
     */
    public static void clear() {
        commentList.clear();
    }
}