class BrowserHistory {
    private class Page {
        private String url;
        private Page previous, next;

        public Page(String url) {
            this.url = url;
        }

        public Page(Page previous, String url) {
            this.previous = previous;
            this.url = url;
        }

        public Page(Page previous, String url, Page next) {
            this.previous = previous;
            this.url = url;
            this.next = next;
        }
    }

    private Page current;

    public BrowserHistory(String homepage) {
        current = new Page(homepage);
    }

    public void visit(String url) {
        current.next = new Page(current, url);
        current = current.next;
    }

    public String back(int steps) {
        while (current.previous != null && steps-- > 0) current = current.previous;
        return current.url;
    }

    public String forward(int steps) {
        while (current.next != null && steps-- > 0) current = current.next;
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */