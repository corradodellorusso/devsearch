package it.corradodellorusso.devsearch.dispatcher;

import com.intellij.ide.BrowserUtil;
import it.corradodellorusso.devsearch.search.Search;

public class Dispatcher {

    public void dispatch(Search search) {
        BrowserUtil.browse(search.toUrl());
    }

}
