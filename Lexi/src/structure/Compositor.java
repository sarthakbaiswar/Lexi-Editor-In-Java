/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import Utilities.ViewArgs;
import java.util.List;

/**
 *
 * @author Sarthak
 */
public interface Compositor {
    List<Row> compose(List<Glyph> glyphs, ViewArgs args);
}
