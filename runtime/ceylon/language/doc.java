package ceylon.language;

import com.redhat.ceylon.compiler.metadata.java.Ceylon;
import com.redhat.ceylon.compiler.metadata.java.Method;
import com.redhat.ceylon.compiler.metadata.java.Name;

@Ceylon
@Method
public final class doc
{
    public static Nothing doc(@Name("description") java.lang.String description) {
        return null;
    }
    private doc(){}
}
