package no.jascorp.powercalc.domain.common;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junitx.framework.Assert.assertNotEquals;
import static junitx.framework.Assert.assertNotSame;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Test;

/**
 * Extend me in order to test a class's functional compliance with the
 * <code>equals</code> and <code>hashCode</code> contract.
 * <p>
 * Override my {@link #createInstance() createInstance} and
 * {@link #createNotEqualInstance() createNotEqualInstance} methods to
 * provide me with objects to test against.  Both methods should return
 * objects that are of the same class.
 * <p>
 * <b>WARNING</b>: Extend me only if your class overrides
 * <code>equals</code> to test for equivalence.  If your class's
 * <code>equals</code> tests for identity or preserves the behavior from
 * <code>Object</code>, I'm not interested, because I expect
 * <code>createInstance</code> to return equivalent but distinct objects.
 *
 * @see java.lang.Object#equals(Object)
 * @see java.lang.Object#hashCode()
 * @version $Revision: 1.2 $ $Date: 2003/02/06 20:43:52 $
 * @author <a href="mailto:pholser@yahoo.com">Paul Holser</a>
 */
public abstract class EqualsHashCodeTestCase {

    private Object eq1;
    private Object eq2;
    private Object eq3;
    private Object neq;
    private static final int NUM_ITERATIONS = 20;

    /**
     * Creates and returns an instance of the class under test.
     *
     * @return  a new instance of the class under test; each object returned
     * from this method should compare equal to each other.
     * @throws  Exception
     */
    protected abstract Object createInstance() throws Exception;

    /**
     * Creates and returns an instance of the class under test.
     *
     * @return a new instance of the class under test; each object returned
     * from this method should compare equal to each other, but not to the
     * objects returned from {@link #createInstance() createInstance}.
     * @throws Exception
     */
    protected abstract Object createNotEqualInstance() throws Exception;
    
    protected abstract Object[] createNullValueInstances();

    /**
     * Sets up the test fixture.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        eq1 = createInstance();
        eq2 = createInstance();
        eq3 = createInstance();
        neq = createNotEqualInstance();

        // We want these assertions to yield errors, not failures.
        try {
            assertNotNull("createInstance() returned null", eq1);
            assertNotNull("2nd createInstance() returned null", eq2);
            assertNotNull("3rd createInstance() returned null", eq3);
            assertNotNull("createNotEqualInstance() returned null", neq);

            assertNotSame(eq1, eq2);
            assertNotSame(eq1, eq3);
            assertNotSame(eq1, neq);
            assertNotSame(eq2, eq3);
            assertNotSame(eq2, neq);
            assertNotSame(eq3, neq);

            assertEquals(
                    "1st and 2nd equal instances of different classes",
                    eq1.getClass(),
                    eq2.getClass());
            assertEquals(
                    "1st and 3rd equal instances of different classes",
                    eq1.getClass(),
                    eq3.getClass());
            assertEquals(
                    "1st equal instance and not-equal instance of different classes",
                    eq1.getClass(),
                    neq.getClass());
        } catch (AssertionFailedError ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    /**
     * Tests whether <code>equals</code> holds up against a new
     * <code>Object</code> (should always be <code>false</code>).
     */
    @Test
    public final void testEqualsAgainstNewObject() {
        Object o = new Object();

        assertNotEquals(o, eq1);
        assertNotEquals(o, eq2);
        assertNotEquals(o, eq3);
        assertNotEquals(o, neq);
    }

    /**
     * Tests whether <code>equals</code> holds up against <code>null</code>.
     */
    @Test
    public final void testEqualsAgainstNull() {
        assertNotEquals("null vs. 1st", null, eq1);
        assertNotEquals("1st vs. null", eq1, null);
        assertNotEquals("null vs. 2nd", null, eq2);
        assertNotEquals("null vs. 3rd", null, eq3);
        assertNotEquals("null vs. not-equal", null, neq);
    }

    /**
     * Tests whether <code>equals</code> holds up against objects that should
     * not compare equal.
     */
    @Test
    public final void testEqualsAgainstUnequalObjects() {
        assertNotEquals("1st vs. not-equal", eq1, neq);
        assertNotEquals("2nd vs. not-equal", eq2, neq);
        assertNotEquals("3rd vs. not-equal", eq3, neq);

        assertNotEquals("not-equal vs. 1st", neq, eq1);
        assertNotEquals("not-equal vs. 2nd", neq, eq2);
        assertNotEquals("not-equal vs. 3rd", neq, eq3);
    }
    
    /**
     * Tests whether <code>equals</code> is <em>consistent</em>.
     */
    @Test
    public final void testEqualsIsConsistentAcrossInvocations() {
        for (int i = 0; i < NUM_ITERATIONS; ++i) {
            testEqualsAgainstNewObject();
            testEqualsAgainstNull();
            testEqualsAgainstUnequalObjects();
            testEqualsIsReflexive();
            testEqualsIsSymmetricAndTransitive();
        }
    }

    /**
     * Tests whether <code>equals</code> is <em>reflexive</em>.
     */
    @Test
    public final void testEqualsIsReflexive() {
        assertEquals("1st equal instance", eq1, eq1);
        assertEquals("2nd equal instance", eq2, eq2);
        assertEquals("3rd equal instance", eq3, eq3);
        assertEquals("not-equal instance", neq, neq);
    }

    /**
     * Tests whether <code>equals</code> is <em>symmetric</em> and
     * <em>transitive</em>.
     */
    @Test
    public final void testEqualsIsSymmetricAndTransitive() {
        assertEquals("1st vs. 2nd", eq1, eq2);
        assertEquals("2nd vs. 1st", eq2, eq1);

        assertEquals("1st vs. 3rd", eq1, eq3);
        assertEquals("3rd vs. 1st", eq3, eq1);

        assertEquals("2nd vs. 3rd", eq2, eq3);
        assertEquals("3rd vs. 2nd", eq3, eq2);
    }
    
    @Test
    public final void testEqualsOverNullValues() {
    	if (createNullValueInstances() != null) {
	    	for (Object nullvalue : createNullValueInstances()) {
	    		assertEquals(nullvalue, nullvalue);
	    	}
    	}
    }
    
    @Test
    public final void testEqualsAgainsAString() {
    	assertNotEquals(eq1, "junit");
    }


    /**
     * Tests the <code>hashCode</code> contract.
     */
    @Test
    public final void testHashCodeContract() {
        assertEquals("1st vs. 2nd", eq1.hashCode(), eq2.hashCode());
        assertEquals("1st vs. 3rd", eq1.hashCode(), eq3.hashCode());
        assertEquals("2nd vs. 3rd", eq2.hashCode(), eq3.hashCode());
    }

    /**
     * Tests the consistency of <code>hashCode</code>.
     */
    @Test
    public final void testHashCodeIsConsistentAcrossInvocations() {
        int eq1Hash = eq1.hashCode();
        int eq2Hash = eq2.hashCode();
        int eq3Hash = eq3.hashCode();
        int neqHash = neq.hashCode();

        for (int i = 0; i < NUM_ITERATIONS; ++i) {
            assertEquals("1st equal instance", eq1Hash, eq1.hashCode());
            assertEquals("2nd equal instance", eq2Hash, eq2.hashCode());
            assertEquals("3rd equal instance", eq3Hash, eq3.hashCode());
            assertEquals("not-equal instance", neqHash, neq.hashCode());
        }
    }
}
