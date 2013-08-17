require 'date'

def count_days(from, to, &pred)
 Date.new(*from).step(Date.new(*to)).select(&pred).count
end

p count_days(1901, [2000, -1, -1]) { |d| d.sunday? && d.day == 1 }
