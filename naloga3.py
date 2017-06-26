import re

def naslednji_niz(niz):
    sez = [m.group(0) for m in re.finditer(r"(\d)\1*", niz)]
    niz2 = ""
    for i in sez:
        niz2+=str(len(i))+i[0]
    return niz2
        

def zaporedje(niz):
    while True:
        niz = naslednji_niz(niz)
        yield(niz)
