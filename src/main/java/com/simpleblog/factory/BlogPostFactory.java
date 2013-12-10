/*
 * Copyright 2013 craigjones.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.simpleblog.factory;

import com.simpleblog.model.BlogPost;
import java.util.ArrayList;

/**
 *
 * @author craigjones
 */
public class BlogPostFactory {
    
    
    /**
     * Create a basic blogpost object to use on the front end
     * @param text
     * @return 
     */
    public BlogPost createSimpleBlogPost(String text){
        BlogPost post = new BlogPost(text);
        return post;
    }
    
    public ArrayList<BlogPost> createListOfBlogs(int numberOfBlogs){
        
        ArrayList<BlogPost> posts = new ArrayList();
        
        for(int i = 0; i < numberOfBlogs ; i++){
            posts.add(new BlogPost("Blog Post " + i));
        }
        return posts;
    }
    
    public void addSomeCommentsToMyBlog(BlogPost post){
        
        // todo
    }
    
    
    
}
