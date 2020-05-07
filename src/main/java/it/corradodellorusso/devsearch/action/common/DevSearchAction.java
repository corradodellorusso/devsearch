package it.corradodellorusso.devsearch.action.common;

import com.intellij.openapi.actionSystem.AnAction;
import it.corradodellorusso.devsearch.dispatcher.Dispatcher;
import it.corradodellorusso.devsearch.dispatcher.DispatcherFactory;
import it.corradodellorusso.devsearch.search.Search;

/**
 * Common base class for all action in this plugin.
 *
 * @author Corrado Dello Russo
 * @see com.intellij.openapi.actionSystem.AnAction
 */
public abstract class DevSearchAction extends AnAction {

    /**
     * Common method to dispatch search the right way.
     *
     * @param search to be dispatched.
     */
    protected void dispatch(Search search) {
        Dispatcher dispatcher = DispatcherFactory.getDispatcherFor(search);
        dispatcher.dispatch(search);
    }

    /**
     * Usually inheritors of this class don't rely on indexing, hence can be run during its execution.
     */
    @Override
    public boolean isDumbAware() {
        return true;
    }
}
