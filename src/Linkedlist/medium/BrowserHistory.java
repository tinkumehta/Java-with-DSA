package Linkedlist.medium;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    static List<String> history;
    static int currentUrl;

    public BrowserHistory(String homePage)
    {
        history = new ArrayList<>();
        history.add(homePage);
        currentUrl =0;
    }
    public void visit(String url)
    {
        history.subList(currentUrl + 1, history.size()).clear();
        history.add(url);
        currentUrl = history.size()-1;
    }
    public String back(int step)
    {
        int n = currentUrl - step;
        currentUrl = Math.max(n, 0);
      return  history.get(currentUrl);
    }
    public String forward(int step)
    {
        int n = currentUrl + step;
        currentUrl = Math.min(n, history.size()-1);
        return history.get(currentUrl);
    }

}
