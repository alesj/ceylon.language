package ceylon.language;

import com.redhat.ceylon.compiler.metadata.java.Name;
import com.redhat.ceylon.compiler.metadata.java.SatisfiedTypes;
import com.redhat.ceylon.compiler.metadata.java.TypeInfo;
import com.redhat.ceylon.compiler.metadata.java.TypeParameter;
import com.redhat.ceylon.compiler.metadata.java.TypeParameters;

@SatisfiedTypes({
    "ceylon.language.Castable<ceylon.language.Natural|ceylon.language.Integer|ceylon.language.Float>",
    "ceylon.language.Integral<ceylon.language.Natural>",
    "ceylon.language.Subtractable<ceylon.language.Natural,ceylon.language.Integer>"
})
public final class Natural
    extends Object
    implements Castable<Numeric>, Integral<Natural>, 
               Subtractable<Natural,Integer> {
    
    final long value;
    private Natural(long l) {
        if (l < 0)
            throw new NegativeNumberException();
        value = l;
    }
    
    public static Natural instance(long l) {
        assert l >= 0;
        return new Natural(l);
    }
    
    @Override
    public Natural plus(@Name("other") Natural op) {
        long result = value + op.value;
        if (result<0) 
        	throw new OverflowException();
		return instance(result);
    }
    
    @Override
    public Integer minus(@Name("other") Natural op) {
        return Integer.instance(value - op.value);
    }
    
    @Override
    public Natural times(@Name("other") Natural op) {
        long result = value * op.value;
        if (result<0) 
        	throw new OverflowException();
        return instance(result);
    }
    
    @Override
    public Natural divided(@Name("other") Natural op) {
        return instance(value / op.value);
    }
    
    @Override
    public Natural power(@Name("other") Natural op) {
        long result = (long) Math.pow(value, op.value); // FIXME: ugly
        if (result==Long.MAX_VALUE) 
        	throw new OverflowException();
        return instance(result);
    }
    
    public Float plus(Float op) {
        return Float.instance(value + op.value);
    }
    
    public Float minus(Float op) {
        return Float.instance(value - op.value);
    }
    
    public Float times(Float op) {
        return Float.instance(value * op.value);
    }
    
    public Float divided(Float op) {
        return Float.instance(value / op.value);
    }
    
    public Float power(Float op) {
        return Float.instance(Math.pow(value, op.value)); // FIXME: ugly
    }
    
    public Integer plus(Integer op) {
        return Integer.instance(value + op.value);
    }
    
    public Integer minus(Integer op) {
        return Integer.instance(value - op.value);
    }
    
    public Integer times(Integer op) {
        return Integer.instance(value * op.value);
    }
    
    public Integer divided(Integer op) {
        return Integer.instance(value / op.value);
    }
    
    public Integer power(Integer op) {
        return Integer.instance((long) Math.pow(value, op.value)); // FIXME: ugly
    }
    
    @Override
    public Natural remainder(@Name("other") Natural op) {
        return instance(value % op.value);
    }
    
    @Override
    public Natural getMagnitude() {
        return this;
    }
    
    @Override
    public Natural getFractionalPart() {		
        return instance(0);
    }
    
    @Override
    public Natural getWholePart() {		
        return this;
    }
    
    @Override
    public boolean getPositive() {
        return value > 0;
    }
    
    @Override
    public boolean getNegative() {
        return value < 0;
    }
    
    @Override
    public long getSign() {
        if (value > 0)
            return 1;
        if (value < 0)
            return -1;
        return 0;
    }	
    
    @Override
    public Integer getPositiveValue() {
        return Integer.instance(value);
    }
    
    @Override
    public Integer getNegativeValue() {
        return Integer.instance(-value);
    }
    
    public boolean test(Natural op) {
        return value == op.value;
    }
    
    @Override
    public Comparison compare(@Name("other") Natural op) {
        long x = value;
        long y = op.value;
        return (x < y) ? Comparison.SMALLER :
            ((x == y) ? Comparison.EQUAL : Comparison.LARGER);
    }
    
    @Override
    public java.lang.String toString() {
        return java.lang.Long.toString(value);
    }
    
    // Conversions between numeric types
    
    @TypeInfo(value="ceylon.language.Natural")
    @Override
    public long getNatural() {
        return value;
    }
    
    @TypeInfo(value="ceylon.language.Integer")
    @Override
    public long getInteger() {
        return value;
    }
    
    @TypeInfo(value="ceylon.language.Float")
    @Override
    public double getFloat() {
        return (double) value;
    }
    
    @Override
    public boolean getUnit() {
        return value==1;
    }
    
    @Override
    public boolean getZero() {
        return value==0;
    }
    
    // Just a kludge til we have full autoboxing
    public long longValue() {
        return value;
    }
    
    @Override
    public Natural getPredecessor() {
        return Natural.instance(value - 1);
    }
    
    @Override
    public Natural getSuccessor() {
        return Natural.instance(value + 1);
    }
    
    public Natural and(Natural op) {
        return Natural.instance(value & op.value);
    }
    
    public Natural or(Natural op) {
        return Natural.instance(value | op.value);
    }
    
    public Natural xor(Natural op) {
        return Natural.instance(value ^ op.value);
    }
    
    @Override
    public boolean equals(@Name("that") @TypeInfo("ceylon.language.Equality") java.lang.Object s) {
        if (s instanceof Natural) {
            return value == ((Natural)s).value;
        } 
        else if (s instanceof Integer) {
            return value == ((Integer)s).value;
        } 
        else if (s instanceof Float) {
            return value == ((Float)s).value;
        } 
        else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
    	return (int)(value ^ (value >>> 32));
    }
    
    @Override
    @TypeParameters({
        @TypeParameter(value = "CastValue", satisfies = "ceylon.language.Natural|ceylon.language.Integer|ceylon.language.Float")
    })
    public <CastValue extends Numeric> CastValue castTo() {
        return (CastValue) this;
    }
    
    @Override
    public java.lang.String getFormatted() {
        return java.lang.Long.toString(value);
    }
    
    @Override
    public boolean largerThan(@Name("other") Natural other) {
        return value > other.value;
    }
    
    @Override
    public boolean smallerThan(@Name("other") Natural other) {
        return value < other.value;
    }
    
    @Override
    public boolean asLargeAs(@Name("other") Natural other) {
        return value >= other.value;
    }
    
    @Override
    public boolean asSmallAs(@Name("other") Natural other) {
        return value <= other.value;
    }
}
