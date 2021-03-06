/*
 * Copyright (c) 2018-2019 DJI
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dji.ux.beta.util;

import dji.common.product.Model;
import dji.sdk.sdkmanager.DJISDKManager;

/**
 * Utility class for product information.
 */
public final class ProductUtil {

    private ProductUtil() {
        // prevent instantiation of util class
    }

    /**
     * Determine whether a product is connected
     *
     * @return `true` if a product is connected. `false` otherwise.
     */
    public static boolean isProductAvailable() {
        return DJISDKManager.getInstance() != null && DJISDKManager.getInstance().getProduct() != null;
    }

    /**
     * Determine whether the connected product is part of the Mavic 2 series.
     *
     * @return `true` if the connected product is part of the Mavic 2 series. `false` if there is
     * no product connected or if the connected product is not part of the Mavic 2 series.
     */
    public static boolean isMavic2SeriesProduct() {
        if (isProductAvailable()) {
            Model model = DJISDKManager.getInstance().getProduct().getModel();
            return Model.MAVIC_2.equals(model)
                    || Model.MAVIC_2_PRO.equals(model)
                    || Model.MAVIC_2_ZOOM.equals(model)
                    || Model.MAVIC_2_ENTERPRISE.equals(model)
                    || Model.MAVIC_2_ENTERPRISE_DUAL.equals(model);
        }
        return false;
    }

    /**
     * Determine whether the connected product is a Mavic 2 Enterprise.
     *
     * @return `true` if the connected product is a Mavic 2 Enterprise. `false` if there is
     * no product connected or if the connected product is not a Mavic 2 Enterprise.
     */
    public static boolean isMavic2Enterprise() {
        if (isProductAvailable()) {
            Model model = DJISDKManager.getInstance().getProduct().getModel();
            return Model.MAVIC_2_ENTERPRISE.equals(model) || Model.MAVIC_2_ENTERPRISE_DUAL.equals(model);
        }
        return false;
    }
}
