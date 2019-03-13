package pl.sda.ConverterProject.Enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Remigiusz Zudzin
 */
public enum DifferentSystemsNumeral {

    A(10), a(10),
    B(11), b(11),
    C(12), c(12),
    D(13), d(12),
    E(14), e(14),
    F(15), f(15),
    G(16), g(16),
    H(17), h(17),
    I(18), i(18),
    J(19), j(19),
    K(20), k(20),
    L(21), l(21),
    M(22), m(22),
    N(23), n(23),
    O(24), o(24),
    P(25), p(25),
    Q(26), q(26),
    R(27), r(27),
    S(28), s(28),
    T(29), t(29),
    U(30), u(30),
    V(31), v(31),
    W(32), w(32),
    X(33), x(33),
    Y(34), y(34),
    Z(35), z(35);

    private int value;

    DifferentSystemsNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
