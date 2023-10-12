# Gayao, Yasmien jen C.
# BSCS 1-B     CC2
def print_row(rows):
  """Prints a row of numbers from 1 to the given row number.
  Args:
    rows: The number of rows to print.
  """
  print(*range(1, rows + 1))
# Print a right triangle with 5 rows.
for i in range(5):
  print_row(i + 1)
