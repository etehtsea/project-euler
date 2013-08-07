fib = 1 : 1 : [ a + b | (a, b) <- zip fib(tail fib) ]
fib_even_list = filter even (takeWhile (< 4000000) fib)
fib_even_sum = foldl (+) 0 fib_even_list
