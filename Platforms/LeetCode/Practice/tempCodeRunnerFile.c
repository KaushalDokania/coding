*= sign;
    if (num>2^31)
        return 2^31-1;
    else if(num < 2^31*-1)
        return 2