/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.introduction;

/**
 *
 * @author Middelma
 */
public class ChapterListItem {
    
    private String path="";
    private String title="";
    private ChapterListItem last = null;
    private ChapterListItem next= null;
    
    public ChapterListItem(String path, String title)
    {
        this.path=path;
        this.title=title;
        
    }
    
    public String getPath()
    {
        return path;
    }
    
    public String toString(){
        return title;
    }

    public ChapterListItem getLast() {
        return last;
    }

    public void setLast(ChapterListItem last) {
        this.last = last;
    }

    public ChapterListItem getNext() {
        return next;
    }

    public void setNext(ChapterListItem next) {
        this.next = next;
    }
    
}
