package org.gunsugunaydin.RestBase.util.constants;

public enum Authority {
    READ,
    WRITE,
    UPDATE,
    USER, //can update delete self object, read anything.
    ADMIN //can read update delete anything.    
}
