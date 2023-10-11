# Gayao, Yasmien Jen C.
# BSCS 1B

def pattern(n):
    result, formula = 0, ''

    for i in range(1, n + 1):
        result += i
        formula += str(i) + '+' if i < n else str(i)

    print(f"input: {n}")
    print(f"formula: {formula}")
    print(f"output: {result}")
  
pattern(4)
