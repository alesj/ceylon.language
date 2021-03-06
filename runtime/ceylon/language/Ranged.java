package ceylon.language;

import com.redhat.ceylon.compiler.metadata.java.Ceylon;
import com.redhat.ceylon.compiler.metadata.java.Name;
import com.redhat.ceylon.compiler.metadata.java.TypeParameter;
import com.redhat.ceylon.compiler.metadata.java.TypeParameters;
import com.redhat.ceylon.compiler.metadata.java.Variance;

@Ceylon
@TypeParameters({
    @TypeParameter(value = "Index", variance = Variance.IN),
    @TypeParameter(value = "Span", variance = Variance.OUT)
})
public interface Ranged<Index extends Comparable<Index>,Span> {
    
	public Span span(@Name("from") Index from, @Name("to") Index to);
    
	public Span segment(@Name("from") Index from, @Name("length") Index length);
	
}
