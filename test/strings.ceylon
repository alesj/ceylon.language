shared void strings() {
    value hello = "hello";
    
    assert(hello.size==5, "string size");
    assert("".size==0, "empty string size");
    assert(!exists "".lastIndex, "empty string last index");
    assert(!exists ""[0], "empty string first element exists");
    
    assert("abcd".size==4, "string size");
    
    assert(hello.span(1,3)=="ell", "string span");
    assert(hello.segment(1,3)=="ell", "string segment");
    assert("".span(1,3)=="", "empty string span");
    assert("".segment(1,3)=="", "empty string segment");
        
    assert(exists hello[0], "string first element exists");
    if (exists li = hello.lastIndex) {
        assert(exists hello[li], "string first element exists");
    }
    else {
        fail("string last index");
    }
    assert (!exists hello[hello.size], "string element not exists");
    if (exists c = hello[0]) {
        assert(c==`h`, "string first element value");
    }
    else {
        fail("string first element exists");
    }
    if (exists c = hello[hello.size.predecessor]) {
        assert(c==`o`, "string last element value");
    }
    else {
        fail("string last element exists");
    }
    if (exists c = hello[hello.size]) {
        fail("string element out of range");
    }
    
    variable value i:=0;
    for (c in hello) {
        value hc = hello[i];
        if (exists hc) {
            assert(hc==c, "iterated string element");
        }
        i+=1;
    }
    assert(i==hello.size, "string iteration");
    for (c in "") {
        fail("empty string iteration");
    }
    
    assert("a"<"z", "string comparison");
    assert("abc"=="abc", "string equality");
    assert("hello"+" "+"world"=="hello world", "string concatenation");
    assert(hello.uppercased=="HELLO", "uppercase");
    assert(hello.uppercased.lowercased==hello, "lowercase");
    assert("GoodBye".lowercased=="goodbye", "lowercase");
    assert(hello.contains("ll"), "string contains");
    assert(!hello.contains("x"), "string contains");
    assert(hello.longerThan(4), "string longer than");
    assert(!hello.longerThan(6), "string longer than");
    assert(!hello.longerThan(5), "string longer than");
    assert(("  " + hello + "\n").trimmed==hello, "string trim");
    assert("hello\n    world\ngoodbye   everyone!".normalized=="hello world goodbye everyone!", "string normalize");
    
    if (exists occ = hello.firstOccurrence("ll")) {
        assert(occ==2, "string first occurrence");
    }
    else {
        fail("string first occurrence");
    }
    if (exists nocc = hello.firstOccurrence("x")) {
        fail("string no first occurrence");
    }
    if (exists locc = "hello hello".lastOccurrence("hell")) {
        assert(locc==6, "string last occurrence");
    }
    else {
        fail("string last occurrence");
    }
        
    value chars = hello.characters;
    if (exists char = chars[0]) {
        assert(char==`h`, "string characters");
    }
    else {
        fail("string characters");
    }
    if (exists char = chars[3]) {
        assert(char==`l`, "string characters");
    }
    else {
        fail("string characters");
    }
    if (exists char = chars[5]) {
        fail("string characters");
    }
    if (exists c = chars.first) {
        assert(c==`h`, "string first character");
    }
    else {
        fail("string first character");
    }
    assert(chars.size==5, "string characters size");
    if (nonempty chars) {
        assert(chars.lastIndex==4, "string characters last index");
    }
    else {
        fail("string characters nonempty");
    }
    if (nonempty nochars = "".characters) {
        fail("string characters empty");
    }
    
    assert(hello.keys.contains(3), "string keys");
    assert(!hello.keys.contains(6), "string keys");
    assert(!hello.keys.contains(5), "string keys");
    //assert(hello.keys.contains(-1), "string keys");
    assert(hello.keys.contains(0), "string keys");
    
    assert(hello.hash==("HE"+"LLO").lowercased.hash, "string hash");
    
    value builder = StringBuilder();
    builder.append("hello");
    builder.appendCharacter(` `);
    builder.append("world");
    String s = builder.string;
    assert(s=="hello world", "string builder");
    builder.appendAll();
    builder.appendAll(" ");
    builder.appendAll("goodbye", " ", "everyone");
    assert(builder.string=="hello world goodbye everyone", "string builder");    
    
    assert("hello world".initial(5)=="hello", "string initial");
    assert("hello world".terminal(5)=="world", "string terminal");
    assert("hello world".initial(20)=="hello world", "string initial");
    assert("hello world".terminal(20)=="hello world", "string terminal");
    
    assert(min({"abc", "xyz", "foo", "bar"})=="abc", "strings min");
    assert(max({"abc", "xyz", "foo", "bar"})=="xyz", "strings max");
    
    assert(", ".join()=="", "string join no strings");
    assert(", ".join("foo")=="foo", "string join one string");
    assert(", ".join("foo", "bar", "baz")=="foo, bar, baz", "string join");
    
    assert("hello world".startsWith(hello), "string starts with");
    assert("hello world".endsWith("world"), "string ends with");
    assert(!"Hello world".startsWith(hello), "string starts with");
    assert(!"hello World".endsWith("world"), "string ends with");
    assert(!"".startsWith(hello), "empty string starts with");
    assert(!"".endsWith("world"), "empty string ends with");
}