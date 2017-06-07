k = 5;
A = zeros(k);
%i = 1,2 = ???
for i = 3:k
    for j = i-2:k
        A(i,j) = abs(4-i+j);
    end
end

[v,d] = eig(A) %Nima vseh enostavnih realnih lastnih vrednosti :((((

[Q,R] = qr(A);
