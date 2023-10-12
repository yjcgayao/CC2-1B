# Gayao, Yasmien jen C.
# BSCS 1-B     CC2
def print_inverted_triangle(rows):
  for i in range(rows, 0, -1):
    print(*range(1, i + 1), sep=' ')
print_inverted_triangle(5)
