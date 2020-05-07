package it.corradodellorusso.devsearch.dispatcher;

import com.intellij.ide.BrowserUtil;
import it.corradodellorusso.devsearch.search.Search;

/**
 * Dispatcher for web lìnks.
 */
public class WebDispatcher implements Dispatcher {

    @Override
    public void dispatch(Search search) {
        BrowserUtil.browse(search.toURI());
    }

}
