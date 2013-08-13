def sum_of_digits(n)
  n.to_s.split('').map(&:to_i).reduce(:+)
end

p sum_of_digits(2**1000)
