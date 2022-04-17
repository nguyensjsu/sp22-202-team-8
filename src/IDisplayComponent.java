
public interface IDisplayComponent  
{
    void addSubComponent( IDisplayComponent c );
    void removeSubCompnent( IDisplayComponent c );
    void setLocation(int x, int y);    
    void display();
    
}
