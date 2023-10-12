# Gayao, Yasmien jen C.
# BSCS 1-B     CC2
def print_inverted_triangle(rows):
  """Prints an inverted triangle of numbers from 1 to the given row number.
  Args:
    rows: The number of rows to print.
  """
  for i in range(rows, 0, -1):
    print(*range(1, i + 1), sep=' ')
# Print an inverted triangle with 5 rows.
print_inverted_triangle(5)
